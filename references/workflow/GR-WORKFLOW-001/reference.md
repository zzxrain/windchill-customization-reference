---
id: GR-WORKFLOW-001
title: Process Role Member Count
category: workflow
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Process Role Member Count

## Scenario

读取 TeamManaged 对象的流程团队，并按 Role 统计参与者。

## Source Basis

- Source-A utils/WorkflowUtil.java
- Source-C base/util/WorkflowUtil.java

## Review Notes

- Role internal name 与 display name 分离。
- 流程 Team 与 Container Team 不要混淆。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
