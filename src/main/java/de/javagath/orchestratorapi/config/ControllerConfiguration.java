package de.javagath.orchestratorapi.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller configuration to match calls with frontends.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ControllerConfiguration {

  /**
   * Returns path to index.html for the blog page.
   *
   * @return path to index.html
   */
  @RequestMapping({"/"})
  public String indexBlog() {
    return "blog/index";
  }
}