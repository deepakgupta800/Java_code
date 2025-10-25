package com.Reactive.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "My Book API",
                version = "1.0.0",
                description = "This is the API used to managing the books",
                termsOfService = "http://example.com/terms",
                contact = @Contact(
                        name = "Deepak Gupta",
                        email = "deepak@example.com",
                        url = "http://example.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class OpenApiConfig {
}
