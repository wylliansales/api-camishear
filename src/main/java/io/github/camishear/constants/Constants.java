package io.github.camishear.constants;

import org.springframework.stereotype.Component;

@Component
public final class Constants {
  
  Constants() {
    throw new IllegalStateException("Utility class");
	} 
  /**
   * Prefixo de erro.
   */
  public static final String LOG_ERROR_PREFIX = "Camishear ERROR --> %S";

	
}
