---
id: GR-XWORKS-004
title: Workflow Form Required Validation Hook
category: xworks
status: candidate
windchill: xworks-version-dependent
xworks: true
verification: xworks-guide-derived-not-runtime-verified
provenance: xworks-guide-derived
---

# Workflow Form Required Validation Hook

## Scenario

复杂流程表单在用户完成任务前，通过 WorkflowTaskFormProcessorDelegate 的 required-condition validation hook 做必须纠正的服务端校验。

## Source Basis

- XWorks 框架快速指南（实战篇）, WorkflowTaskFormProcessorDelegate execution/validation hooks。

## Review Notes

- “保存”与“完成任务”校验是不同语义，不应只写一个通用 validation 方法。
- Required-condition 校验失败时应阻止 Complete，并返回明确 FeedbackMessage。
- 可忽略 warning 应使用 optional-condition hook，不要混在 required validation 中。

## Agent Guidance

- 本 Reference 以 用户提供的 XWorks 框架快速指南 的定制模式为主要依据，并做了最小化、去业务化和必要注释规范化。
- `guide-derived` 表示来源有文档依据，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认 Project `AGENTS.md` 中的 Windchill Version、XWorks 状态、项目架构和适用场景。
- 精确 PTC/XWorks Class、Method、Signature 与 Supported/Extendable 状态应通过目标版本 Javadoc、XWorks Javadoc 或实际项目依赖再次确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
