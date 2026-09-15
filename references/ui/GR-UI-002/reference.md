---
id: GR-UI-002
title: DataUtility TextBox
category: ui
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# DataUtility TextBox

## Scenario

AbstractDataUtility 返回预填值 TextBox，并使用标准列名。

## Source Basis

- Source-A workflow/datautility/WorkFlowNameDataUtility.java

## Review Notes

- 复杂业务读取应放 Helper/Service，不把 DataUtility 做成大型业务层。
- ModelContext/NmCommandBean 的对象来源需结合页面场景判断。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
