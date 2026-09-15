---
id: GR-WORKFLOW-003
title: Reassign WorkItem via Workflow Service
category: workflow
status: candidate
windchill: 13.1.2.0-javadoc-corrected
xworks: false
verification: source-and-javadoc-derived-not-runtime-verified
provenance: legacy-normalized-with-javadoc-correction
---

# Reassign WorkItem via Workflow Service

## Scenario

通过 `WorkflowHelper.service.delegate(workItem, principal)` 执行工作流任务转办。

## Source Basis

- 历史项目 ReassignFormProcessor。
- Windchill 13.1.2.0 Javadoc: `wt.workflow.work.WorkflowService#delegate(WorkItem, WTPrincipal)`。

## Review Notes

- 原历史实现使用了错误 package/signature 的 `StandardWorkflowService.delegate(..., reason)`，不作为 Golden Pattern 保留。
- 转办前后的团队成员、流程变量、审计说明等属于项目业务规则，不能由通用 helper 擅自补齐。
- 是否允许转办必须结合当前用户权限与流程状态验证。

## Agent Guidance

- 使用 service interface/helper，而不是自行 new Standard service implementation。
- 精确 API 必须按目标版本 Javadoc / API Lookup 验证。
