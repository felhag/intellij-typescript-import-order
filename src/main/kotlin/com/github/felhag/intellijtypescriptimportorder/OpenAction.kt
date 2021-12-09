package com.github.felhag.intellijtypescriptimportorder

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import git4idea.repo.GitRepositoryManager
import org.apache.commons.lang3.StringUtils

abstract class OpenAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val instance = GitRepositoryManager.getInstance(e.project!!)
        val remote = instance.repositories[0].remotes.iterator().next().urls[0]
        val splitted = StringUtils.split(StringUtils.removeEnd(remote, ".git"), "/")
        val repo = splitted[splitted.size - 1]
        val project = splitted[splitted.size - 2]
        val targetUrl = buildUrl(project, repo)
        BrowserUtil.browse(targetUrl)
    }

    protected abstract fun buildUrl(project: String, repo: String): String
}
