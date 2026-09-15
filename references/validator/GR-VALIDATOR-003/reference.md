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

- 标准 renderer 已处理 required 等基础客户端检查；复杂表单约束在服务器端 validator 校验。
- 校验失败应返回 `DENIED` 并给用户可理解的 Feedback。
- form data 可通过 `UIValidationCriteria` 获取。
- `validateFormSubmission()` 是 Wizard / UI 提交链路中的服务端验证点，不等同于整个业务操作的最终授权或安全边界。
- FormProcessor / Service 在真正执行敏感业务操作时，仍应重新保证必要的权限、对象状态、Version / Working Copy 和核心业务约束。
- 不得因为 post-select validation 支持某个 `UIValidationStatus`，就推断 `validateFormSubmission()` 阶段也支持完全相同的状态或客户端行为。
- 例如 `PROMPT_FOR_CONFIRMATION` 是否适用于具体提交阶段，必须以目标版本官方 API / Guide 行为为准，不得从其他 validation phase 类比得出。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示“来源比历史项目更可靠”，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 不得把本 Reference 描述为“整个业务系统的最终防线”；它只定义 UI / Wizard 提交阶段的服务端验证模式。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。