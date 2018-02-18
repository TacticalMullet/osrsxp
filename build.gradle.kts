buildscript {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
    dependencies {
        classpath("com.github.hurricup:gradle-grammar-kit-plugin:2017.1.1")
    }
}

plugins {
    kotlin("jvm") version "1.2.21" 
    idea
    maven
}

repositories {
    jcenter() 
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib", "1.2.21")) 
    testImplementation("junit:junit:4.12") 
    compile("khttp:khttp:0.1.0")
    compile("com.google.code.gson:gson:2.8.0")
}

