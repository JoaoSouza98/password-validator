import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "com.itidigital"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter:2.6.2")
	implementation("org.springframework.boot:spring-boot-starter-web:2.6.2")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.4")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")

	testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.2")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
	testImplementation("io.mockk:mockk:1.12.2")
	implementation("io.rest-assured:kotlin-extensions:4.5.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
