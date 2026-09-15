---
id: GR-PERSISTENCE-001
title: Transaction Boundary
category: persistence
status: candidate
windchill: multi-version-candidate
xworks: false
verification: guide-and-source-derived-not-runtime-verified
provenance: legacy-normalized-confirmed-by-ptc-guide
---

# Transaction Boundary

## Scenario

将一组持久化操作作为一个逻辑事务提交，异常时回滚。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide。
- Source-C workflow/WorkflowProcessHelper.java
- Source-A epmDocument/listener/EpmDocumentListener.java

## Review Notes

- PTC Customization Guide 的事务示例采用 `Transaction.start()` / `commit()`，并在 finally 中对未提交事务 `rollback()`。
- PTC Customization Guide 的事务示例采用 `Transaction.start()` / `commit()`，并在 finally 中对未提交事务 `rollback()`。
- 适用于需要原子性的多步数据库修改。
- 不要把外部 HTTP/长耗时操作无条件包进数据库事务。
- 实际 API/异常语义按目标版本 Javadoc 验证。

## Agent Guidance

- 本 Reference 是从历史项目中抽取并规范化的候选模式，不是 PTC 官方事实来源。
- 使用前必须确认当前 Project `AGENTS.md` 的 Windchill Version、XWorks 状态和项目架构约束。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态必须通过目标版本 Javadoc / API Lookup 验证。
- 不得机械复制客户特定常量、类型、Role、State、Queue Name 或 Attribute Internal Name。
- 如与企业 Rules 冲突，以 Rules / Approved Project Exception 为准。
