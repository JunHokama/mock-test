package junhokama.com.github.springmock.togglz;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum MyFeatures implements Feature {
    @Label("URL da API")
    URL,

    @Label("URL Local com Wiremock")
    URL_LOCAL;

}
