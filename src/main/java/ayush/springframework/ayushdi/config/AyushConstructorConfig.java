package ayush.springframework.ayushdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

// Recent addition to spring framework(constructor binding)
// Gives an extra security as properties not being changed at runtime
//Properties will get bound at initialisation

@ConstructorBinding
@ConfigurationProperties("ayush")
public class AyushConstructorConfig {
    private final String username;
    private final String password;
    private final String jdbcurl;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }

    public AyushConstructorConfig(String username, String password, String jdbcurl) {
        this.username = username;
        this.password = password;
        this.jdbcurl = jdbcurl;
    }

}
