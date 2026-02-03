//Use this style above Main.class
@JokerDbConfig(
        type = DbType.POSTGRES,
        name = "postgres",
        username = "postgres",
        password = "123"
)


//dependencies plugin
<repositories>
        <repository>
            <id>github</id>
            <url>https://maven.pkg.github.com/nainglynnaung-dev/joker_db_config</url>
        </repository>
    </repositories>
    <dependencies>
    
        <dependency>
            <groupId>com.jokerdb.mm</groupId>
            <artifactId>jokerdb</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    </dependencies>
