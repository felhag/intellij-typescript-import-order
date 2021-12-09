package com.github.felhag.intellijtypescriptimportorder

class OpenJenkins : OpenAction() {
    override fun buildUrl(project: String, repo: String): String {
        return "${Settings.get().jenkinsUrl}/job/$project/job/$repo"
    }
}
