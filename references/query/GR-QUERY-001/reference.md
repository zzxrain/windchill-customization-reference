---
id: GR-QUERY-001
title: QuerySpec by Attribute
category: query
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# QuerySpec by Attribute

## Scenario

按对象属性进行简单精确查询。

## Source Basis

- Source-C base/util/QueryUtil.java

## Review Notes

- 优先使用 PersistenceHelper.manager.find 以保留访问控制语义。
- 如果使用 Server-side query 绕过 ACL，必须显式说明原因和风险。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
