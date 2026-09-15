---
id: GR-WRS-001
title: WRSCaller Customization Boundary
category: wrs
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# WRSCaller Customization Boundary

## Scenario

在服务端定制中评估 WRSCaller 时，明确其 HTTP/事务边界、当前 Principal access control，以及禁止在 DataUtility/Event Listener/WRS 自定义内部继续调用 WRSCaller 的约束。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Windchill Customization Using Windchill REST Services (WRS), pp. 42-46.

## Review Notes

- WRSCaller 的 POST/PUT/PATCH/DELETE 是独立 HTTP 调用，外层 `wt.pom.Transaction` 不能回滚其数据修改。
- WRSCaller 调用遵循当前 Principal 的 access control。
- Guide 明确不建议在 custom DataUtility、event listener，以及 WRS domain customization 内使用 WRSCaller。
- 这条 Reference 主要用于架构选择与代码审查，不提供“为了调用方便而套 WRS”的通用 helper。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的定制模式为主要依据，并做了最小化、去业务化和必要注释规范化。
- `guide-derived` 表示来源有文档依据，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认 Project `AGENTS.md` 中的 Windchill Version、XWorks 状态、项目架构和适用场景。
- 精确 PTC/XWorks Class、Method、Signature 与 Supported/Extendable 状态应通过目标版本 Javadoc、XWorks Javadoc 或实际项目依赖再次确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
