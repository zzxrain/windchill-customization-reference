---
id: GR-CONFIGSPEC-002
title: Resolve Latest / Working Iteration in Custom Config Spec
category: configspec
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Resolve Latest / Working Iteration in Custom Config Spec

## Scenario

CustomConfigSpecDelegate 的 query 返回多个 iteration 时，在 `process()` 阶段使用 LatestConfigSpec 进一步筛选，使 Working Copy/Original 的版本语义由 Windchill config-spec 能力处理。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Creating Custom Configuration Specifications, Handling Working and Original Versions, pp. 2050-2051.

## Review Notes

- Guide 明确说明 Working Version 是否能被选出，首先取决于 appendSearchCriteria 不能提前把它排除。
- `LatestConfigSpec.process()` 是示例中的优先方式；若查询本身无法包含 Working Copy，则需要更复杂的 working-copy replacement 逻辑。
- 不要在通用 Reference 中手工比较 version/iteration 字符串。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的定制模式为主要依据，并做了最小化、去业务化和必要注释规范化。
- `guide-derived` 表示来源有文档依据，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认 Project `AGENTS.md` 中的 Windchill Version、XWorks 状态、项目架构和适用场景。
- 精确 PTC/XWorks Class、Method、Signature 与 Supported/Extendable 状态应通过目标版本 Javadoc、XWorks Javadoc 或实际项目依赖再次确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
