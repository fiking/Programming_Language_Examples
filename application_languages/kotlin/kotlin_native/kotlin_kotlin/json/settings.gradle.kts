pluginManagement {
    repositories {
        mavenLocal()
        maven(url = "https://maven.byted.org/repository/android_public")
        maven(url = "https://maven.byted.org/repository/bytedance_android/")
        maven(url = "https://maven.byted.org/nexus/content/repositories/bytedance_android/")
        maven(url = "https://maven.byted.org/nexus/content/repositories/ss_app_android/")
        maven(url = "https://maven.byted.org/repository/bytedance_android/")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven(url = "https://maven.byted.org/repository/android_public")
        maven(url = "https://maven.byted.org/repository/bytedance_android/")
        maven(url = "https://maven.byted.org/nexus/content/repositories/bytedance_android/")
        maven(url = "https://maven.byted.org/nexus/content/repositories/ss_app_android/")
        maven(url = "https://maven.byted.org/repository/bytedance_android/")
        mavenCentral()
    }
}

