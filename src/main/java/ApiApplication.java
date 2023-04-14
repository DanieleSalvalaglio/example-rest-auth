import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
    tags = {
            @Tag(name="Greeting Resource", description="Greeting Resource"),
            @Tag(name="User Resource", description="User Resource")
    },
    servers = @Server(
        url = "http:localhost:8080/q/openapi",
        description = "Optional dev mode server description"),
    info = @Info(
        title="Quarkus boilerplate API",
        description="A simple boilerplate for quarkus project",
        version = "1.0.0",
        contact = @Contact(
            name = "Example API Support",
            url = "http://exampleurl.com/contact",
            email = "techsupport@example.com"),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class ApiApplication extends Application {
}