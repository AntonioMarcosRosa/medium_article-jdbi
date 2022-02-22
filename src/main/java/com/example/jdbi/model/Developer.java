package com.example.jdbi.model;

import lombok.*;
import org.jdbi.v3.core.mapper.reflect.JdbiConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__({@JdbiConstructor}))
public class Developer {

    private Long developerId;

    @NonNull
    private String name;

}
