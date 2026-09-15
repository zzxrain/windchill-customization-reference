---
id: GR-LIFECYCLE-001
title: Lifecycle State Change
category: lifecycle
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Lifecycle State Change

## Scenario

通过 LifeCycleHelper 设置对象生命周期状态。

## Source Basis

- Source-A workflow/promotion/expressions/EBomSetReleaseRobotExpression.java
- Source-C workflow/expression/ChangePidState.java

## Review Notes

- 状态 internal name 必须来自目标 Lifecycle Template/项目定义。
- 不能把直接 set state 当成所有流程场景的通用替代方案。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
