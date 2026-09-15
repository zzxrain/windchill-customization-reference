---
id: GR-VALIDATOR-003
title: Wizard Post-Submit Validation
category: validator
status: candidate
windchill: 13.1.2.0-guide-derived
xworks: false
verification: guide-derived-not-runtime-verified
provenance: ptc-customization-guide-13.1.2.0-derived
---

# Wizard Post-Submit Validation

## Scenario

在 validateFormSubmission() 中进行 MethodServer 侧表单校验，并用 PERMITTED / DENIED 与 FeedbackMessage 控制 wizard 下一步或提交。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Creating Data Validators for Your Steps / Post-Submit Validation, pp. 797-798 and 843-844.

## Review Notes

- 标准 renderer 已处理 required 等基础客户端检查；复杂约束在服务器端 validator 校验。
- 校验失败应返回 DENIED 并给用户可理解的 Feedback。
- form data 可通过 UIValidationCriteria 获取。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。
