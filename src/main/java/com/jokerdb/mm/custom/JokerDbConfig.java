package com.jokerdb.mm.custom;

import com.jokerdb.mm.constant.DbType;import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(JokerDbImportSelector.class)
public @interface JokerDbConfig {

    DbType type();
    String name();
    String username();
    String password();
}
