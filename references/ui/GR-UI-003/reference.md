---
id: GR-UI-003
title: JCA Table Builder
category: ui
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# JCA Table Builder

## Scenario

AbstractComponentBuilder 分离 TableConfig 与 Data 构建。

## Source Basis

- Source-B workflow/changeActivity/builder/ChangeBomDataInfoTableBuilder.java

## Review Notes

- Builder 尽量保持无状态；不要把 request-specific 数据存为实例字段。
- Config/Data 分离便于测试和复用。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
