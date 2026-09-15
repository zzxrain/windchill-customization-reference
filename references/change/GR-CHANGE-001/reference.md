---
id: GR-CHANGE-001
title: Query Change Orders by Number
category: change
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Query Change Orders by Number

## Scenario

通过结构化查询查找 WTChangeOrder2。

## Source Basis

- Source-C change/service/ChangeServiceImpl.java

## Review Notes

- 已规范化为 Windchill 常用的 `QuerySpec + SearchCondition + PersistenceHelper.manager.find` 写法，不依赖项目私有 Query DSL。
- 单 Class QuerySpec 的结果按 `WTChangeOrder2` 直接读取；不要套用多 Class Join 查询中 `Persistable[]` 的结果处理方式。
- LIKE pattern 应由调用方明确构造并尽量收窄，避免意外宽查询。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
