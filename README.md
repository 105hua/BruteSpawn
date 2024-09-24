# PaperPluginTemplate-Java

Put simply, this template is an example plugin for the PaperMC Server Software, written in
Java. It comes along with a few dependencies and configurations that I normally use when
creating a Minecraft Plugin, such as ShadowJar, for making the plugin a standalone JAR file,
as well as Spotless, for code formatting.

## How to use

Please follow these steps to fully prepare the template for your own use:

- In the top right corner of this page, click the green "Use this template" button. From
there, you can follow the instructions to create a new repository based on this template.
- Clone your new repository to your local machine and open it in your preferred IDE. For
the sake of simplicity, this tutorial will assume you are using IntelliJ IDEA.
- Open the `build.gradle` file and change the `group` variable to your own package name. You
may also change the `version` variable to your own version number, if you wish.
- Open the `src` folder and navigate to `main`, `java`, and select the
- `joshdev.paperPluginTemplateJava` package. Rename this package to your own package name. This
should also rename the main class file, so you don't need to worry about that.
- Open the `plugin.yml` file within the `resources` directory and change the `name` and `main`
variables to your own plugin name and main class path, respectively.
- Open the `settings.gradle` file and change the `rootProject.name` variable to your own
repository name.
- Open the `README.md` file and customise as required.
- You're all set! You can now start developing your plugin.