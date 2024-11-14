plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0" // Ensure the plugin version is correct
}

group = "edu.bsu.cs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.xerial:sqlite-jdbc:3.47.0.0")
    implementation("org.slf4j:slf4j-nop:2.0.11")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("net.minidev:json-smart:2.5.0")
    implementation("org.json:json:20231013")
    testImplementation("org.testfx:testfx-junit5:4.0.15-alpha")
}
javafx {
    version = "22"
    modules("javafx.controls", "javafx.fxml")
    configuration = ("implementation")
}
application {
    mainClass.set("edu.bsu.cs.LibraryCatalogGUI")
}

tasks.test {
    useJUnitPlatform()
}