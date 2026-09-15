---
id: GR-UI-007
title: Custom DataUtility with Column Prefetch
category: ui
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Custom DataUtility with Column Prefetch

## Scenario

当标准 DataUtility 不能满足显示需求时继承 AbstractDataUtility，并把批量数据预取放到 setModelData()，避免在每个 cell 的 getDataValue() 中重复查询。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Data Utilities, pp. 678-679.

## Review Notes

- Guide 明确提醒避免在 getDataValue() 中做数据库查询。
- 表格列需要外部数据时，优先在 setModelData() 批量加载并缓存。
- 如果已有 OOTB DataUtility 可扩展，应优先复用现有实现。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
