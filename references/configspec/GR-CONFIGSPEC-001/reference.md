---
id: GR-CONFIGSPEC-001
title: Custom Configuration Spec Delegate
category: configspec
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Custom Configuration Spec Delegate

## Scenario

实现 CustomConfigSpecDelegate，从 Edit Filter attributesMap 读取输入，在 appendSearchCriteria/process 中实现结构版本解析逻辑，并通过 service XCONF 注册。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Creating Custom Configuration Specifications, pp. 2025-2032 and 2050-2051.

## Review Notes

- `appendSearchCriteria` 负责构造过滤 QuerySpec，`process` 负责结果后处理。
- attributesMap 的 key 对 MBA/local/global attribute 使用不同命名规则，必须按 Type Manager 配置匹配。
- Working/Original copy 处理是版本语义敏感点，必须按实际场景设计。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
