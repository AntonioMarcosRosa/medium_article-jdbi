package com.example.jdbi.repository;

import com.example.jdbi.dto.response.DeveloperResponseDto;
import com.example.jdbi.model.Developer;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Optional;

public interface DeveloperRepository {

    @SqlUpdate("INSERT INTO developer " +
            "(      name" +
            ") VALUES " +
            "(      :name)")
    @GetGeneratedKeys
    Long saveNewDeveloper(@BindBean Developer developer);

    @SqlQuery("SELECT * FROM developer WHERE developer_id = :developerId")
    @RegisterBeanMapper(DeveloperResponseDto.class)
    Optional<DeveloperResponseDto> findDeveloperById(@Bind("developerId") Long developerId);

    @SqlUpdate("UPDATE developer SET" +
            "      name = :name" +
            " WHERE developer_id = :developerId")
    void updateDeveloper(@BindBean Developer developer);

    @SqlUpdate("DELETE from developer WHERE developer_id = :developerId")
    void removeDeveloperById(@Bind("developerId") Long developerId);

}
