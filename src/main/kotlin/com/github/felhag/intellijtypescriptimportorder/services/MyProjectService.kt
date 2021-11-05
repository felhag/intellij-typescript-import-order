package com.github.felhag.intellijtypescriptimportorder.services

import com.intellij.openapi.project.Project
import com.github.felhag.intellijtypescriptimportorder.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
