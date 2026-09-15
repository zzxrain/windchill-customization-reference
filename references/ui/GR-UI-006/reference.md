---
id: GR-UI-006
title: Attribute Panel Builder Pattern
category: ui
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Attribute Panel Builder Pattern

## Scenario

使用 AbstractAttributesComponentBuilder/ComponentConfigFactory 创建 AttributePanelConfig，并将属性分组组织。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Simple or Advanced Attribute Panel Using a Java Builder, pp. 362-366.

## Review Notes

- TypeManaged 对象优先评估 Type and Attribute Management layout-based panel。
- Java builder 更适合非 TypeManaged 对象或确有代码级布局需求的场景。
- UI label 应资源化，不建议硬编码。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
