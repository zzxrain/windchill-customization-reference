---
id: GR-VALIDATOR-002
title: UI Post-Select Validation
category: validator
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# UI Post-Select Validation

## Scenario

对用户已经选择的 Action 执行 post-select validation，返回 PERMITTED、DENIED 或 PROMPT_FOR_CONFIRMATION。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Procedures - Post-select Validation, pp. 795-797.

## Review Notes

- Single-select 与 multi-select validation 的返回类型不同。
- PROMPT_FOR_CONFIRMATION 需要对应客户端 action 配置配合。
- 不要把 pre-validation 和真正提交前授权检查混为一谈。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
