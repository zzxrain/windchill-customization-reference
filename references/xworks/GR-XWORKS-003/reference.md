---
id: GR-XWORKS-003
title: XmlObject SaveOption Semantics
category: xworks
status: candidate
windchill: xworks-version-dependent
xworks: true
verification: xworks-guide-derived-not-runtime-verified
provenance: xworks-guide-derived
---

# XmlObject SaveOption Semantics

## Scenario

保存带子对象的 XmlObject 时显式选择 SaveOption，区分“追加并更新”和“替换并更新”，避免因为默认行为误删或遗留子对象。

## Source Basis

- XWorks 框架快速指南（实战篇）, XmlObjectStoreManager / StoreOptions.SaveOption。

## Review Notes

- `APPEND_AND_UPDATE` 不会删除本次集合中缺失的既有 child。
- 替换语义可能删除之前已保存但本次不再存在的 sub-XmlObject，使用前必须确认业务意图。
- 对复杂表单保存逻辑，SaveOption 应成为显式设计决策，而不是依赖默认值。

## Agent Guidance

- 本 Reference 以 用户提供的 XWorks 框架快速指南 的定制模式为主要依据，并做了最小化、去业务化和必要注释规范化。
- `guide-derived` 表示来源有文档依据，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认 Project `AGENTS.md` 中的 Windchill Version、XWorks 状态、项目架构和适用场景。
- 精确 PTC/XWorks Class、Method、Signature 与 Supported/Extendable 状态应通过目标版本 Javadoc、XWorks Javadoc 或实际项目依赖再次确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
