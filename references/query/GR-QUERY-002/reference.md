---
id: GR-QUERY-002
title: Query Result Iteration
category: query
status: candidate
windchill: multi-version-candidate
xworks: false
verification: source-derived-not-runtime-verified
---

# Query Result Iteration

## Scenario

安全遍历 QueryResult，并明确处理返回元素形态。

## Source Basis

- Source-C change/service/ChangeServiceImpl.java
- Source-C base/util/QueryUtil.java

## Review Notes

- 不要假设所有 QueryResult 都返回同一种 row 结构。
- 具体查询结果形态应结合 QuerySpec/Select 结构确认。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
