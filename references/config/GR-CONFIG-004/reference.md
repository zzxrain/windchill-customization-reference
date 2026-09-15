---
id: GR-CONFIG-004
title: Custom LogicalAttributesSite Configuration
category: config
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Custom LogicalAttributesSite Configuration

## Scenario

自定义 logical attribute 时优先创建独立 LogicalAttributesSite.xml，并通过 translatorSelectors property 指向自定义配置。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Managing the LogicalAttributes.xml File, p. 136.

## Review Notes

- 避免直接把站点定制全部写入 PTC LogicalAttributes.xml。
- 自定义文件仍应进入站点 customization/source management。
- property 名称为版本敏感产品事实，目标版本部署前应再次确认。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
