---
id: GR-VALIDATOR-001
title: UI Pre-Validation
category: validator
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# UI Pre-Validation

## Scenario

继承 DefaultUIComponentValidator，通过 pre-validation 返回 ENABLED / DISABLED / HIDDEN，控制 Action/UI component 是否可见和可用。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Adding Validation Logic for Actions and Properties, pp. 429-436 and Presenting Information in the UI validation examples.

## Review Notes

- Validator 应只获取 validation 所需数据，并保持高性能。
- Role/install/client 基础检查由 validation service 处理，不必在每个自定义 Validator 重复实现。
- 业务对象权限与状态判断仍需在 Validator 中按业务要求完成。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
