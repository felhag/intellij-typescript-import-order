package com.github.felhag.intellijtypescriptimportorder

import org.apache.commons.lang.StringUtils

class OpenJenkins : OpenAction() {
    override fun buildUrl(project: String, repo: String): String {
        val url = StringUtils.removeEnd(Settings.get().jenkinsUrl, "/")
        return "${url}/job/$project/job/$repo"
    }
}
