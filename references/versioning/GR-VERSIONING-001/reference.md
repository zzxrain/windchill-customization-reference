---
id: GR-VERSIONING-001
title: Latest Iteration Guard
category: versioning
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Latest Iteration Guard

## Scenario

在业务需要最新迭代时，显式获取最新迭代。

## Source Basis

- Source-A part/PartHelper.java
- Source-B doc/listener/DocumentListenerServiceAdapter.java

## Review Notes

- 先确认业务语义是“最新迭代”还是“最新版本的最新迭代”。
- Master、Version、Iteration 不可混为一谈。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
