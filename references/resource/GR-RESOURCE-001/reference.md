---
id: GR-RESOURCE-001
title: Localized Resource Bundle for UI Labels
category: resource
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Localized Resource Bundle for UI Labels

## Scenario

JCA/UI label 使用 Windchill resource bundle，而不是把显示文字硬编码在 Builder/Validator/FormProcessor 中。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Getting Started Pet Table localized resource example, pp. 87-88; System Generation localized text, p. 2265.

## Review Notes

- UI label、反馈消息和 action text 应资源化。
- 真实 package/resource class 名应使用公司命名空间。
- 资源编译/部署流程按目标版本 Windchill 工具链执行。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
