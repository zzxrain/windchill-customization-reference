---
id: GR-CONFIG-002
title: Safe Area for Customized PTC Files
category: config
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Safe Area for Customized PTC Files

## Scenario

当官方定制机制确实要求修改 PTC 提供文件时，在 wtSafeArea/ptcOrig 保留原始文件，并在 wtSafeArea/siteMod 保存站点修改版本。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Managing Customizations / wtSafeArea guidance, pp. 118-136.

## Review Notes

- 优先避免直接修改 PTC 文件；只有官方定制方式要求时才使用此模式。
- ptcOrig 保存未修改原版，siteMod 保存定制版本。
- 该 Reference 是文件管理模式，不是“鼓励修改 OOTB 文件”。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
