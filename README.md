# orchestrator-api

Hello again!

My whole web-application based on many services.
<br>All of them need a single entry point and have to be managed by it.
<br>This application is created to do it.
<br>The mapping between endpoints and frontend sources is
declared
in **ControllerConfiguration**-Class.

The structure of the whole application you can see on the image below.
Orchestration-Api hosts compiled frontends and manages access to other services.
<img src="https://github.com/JavaGath/JavaGath/blob/main/javagath-app-structure.png?raw=true" width="700">

To test the mapping, just place a dummy index.html into

```
classpath:static/blog
```

and try to call localhost:8080. You should see there your page.