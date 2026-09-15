---
id: GR-WORKFLOW-002
title: Resolve WorkItem Context
category: workflow
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Resolve WorkItem Context

## Scenario

从 WorkItem 获取 Activity 和 Primary Business Object。

## Source Basis

- Source-B part/validation/HideForEditMaterialAttributeValidator.java
- Source-B workflow/process/ReassignFormProcessor.java

## Review Notes

- 使用前应检查 Reference 是否为空以及对象类型。
- WorkItem 上下文常用于 Validator/FormProcessor，但不能替代服务端安全校验。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
