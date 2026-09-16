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

在 `validateFormSubmission()` 中进行 MethodServer 侧表单提交校验，并根据业务结果返回 `PERMITTED`、`DENIED` 或 `PROMPT_FOR_CONFIRMATION`。

其中：

- `PERMITTED`：允许继续提交；
- `DENIED`：阻止提交，并向用户提供可理解的校验反馈；
- `PROMPT_FOR_CONFIRMATION`：允许在提交前向用户显示确认提示，但需要对应的客户端 Post-Submit Validation 配置配合。

## Source Basis

- PTC Windchill 13.1.2.0 Customization Guide, Procedures – Post-Submit Validation / How to Handle UIValidationStatus.PROMPT_FOR_CONFIRMATION, pp. 797-799.
- PTC Windchill 13.1.2.0 Customization Guide, Creating Data Validators for Your Steps / Post-Submit Validation, pp. 843-844.

## Review Notes

- Post-Submit Validation 只适用于 Wizard Step 和 Wizard Submission。
- `validateFormSubmission()` 在 Wizard 的 `Next` 或 `Finish` 操作之后执行，用于判断用户提交的数据是否允许继续处理。
- Windchill 13.1.2.0 Customization Guide 明确展示 `validateFormSubmission()` 可以返回：
  - `UIValidationStatus.PERMITTED`
  - `UIValidationStatus.DENIED`
  - `UIValidationStatus.PROMPT_FOR_CONFIRMATION`
- `PROMPT_FOR_CONFIRMATION` 不是仅属于 Post-Select Validation 的状态；Windchill 13.1.2.0 Guide 在 Post-Submit Validation 章节中独立明确支持该状态。
- Post-Submit 的 `PROMPT_FOR_CONFIRMATION` 需要对应客户端提交逻辑配合。Guide 给出了 `PTC.validation.AJAXValidateFormAndSubmit(...)` 和 `PTC.validation.AJAXValidateFormSubmission(...)` 的配置示例。
- 用户确认继续，或 Validator 返回 `PERMITTED` 后，Wizard 会继续提交；Guide 同时说明后续操作请求具有避免再次调用该 Validator 的 Framework 行为。
- 标准 renderer 已处理 required 等基础客户端检查；复杂表单约束仍应在服务器端 Validator 中确认。
- 校验失败应返回 `DENIED` 并给用户可理解、可本地化的 Feedback。
- 表单提交数据可通过 `UIValidationCriteria` 获取，例如需要时读取 form data。
- `validateFormSubmission()` 是 Wizard / UI 提交链路中的服务端验证点，不等同于整个业务操作的最终授权或安全边界。
- FormProcessor / Service 在真正执行敏感业务操作时，仍应重新保证必要的权限、对象状态、Version / Working Copy 和核心业务约束。
- 不同 Validation Phase 的状态和客户端行为不能仅靠名称或相似性互相推导；本 Reference 中对 `PROMPT_FOR_CONFIRMATION` 的结论来自 Windchill 13.1.2.0 Post-Submit Validation 官方资料本身。
- XWorks `optional-condition` 可以作为“可提示但允许继续”的需求设计参考，但不能据此声明它与 Windchill OOTB `validateFormSubmission() + PROMPT_FOR_CONFIRMATION` 存在一一对应关系。

## Evidence Boundary

本 Reference 涉及两类不同证据：

### API Fact

以下内容应由目标版本 Javadoc / API Lookup 确认：

- Class 是否存在；
- Method 是否存在；
- Method Signature；
- Return Type；
- Checked Exception；
- Supported / Extendable / Deprecated 状态。

### Framework Behavior

以下内容属于 Windchill UI Framework 行为，应优先由目标版本 Customization Guide / 官方产品文档确认：

- Post-Submit Validation 的触发阶段；
- `UIValidationStatus` 在该阶段的业务语义；
- `PROMPT_FOR_CONFIRMATION` 的客户端交互；
- Validator 与后续 Wizard Submit Request 的调用关系。

不能仅根据 Java Method Signature 推导 Framework 行为。

## Agent Guidance

- 本 Reference 以 PTC Windchill 13.1.2.0 Customization Guide 的公开定制模式为主要依据，并做了去示例业务化、最小化和注释规范化。
- `guide-derived` 表示来源有官方文档依据，不等于当前项目已经编译或 Runtime Verification 通过。
- 使用前仍必须确认当前 Project `AGENTS.md` 的 Windchill Version、项目架构和适用场景。
- 对 Windchill 13.1.2.0，Post-Submit `PROMPT_FOR_CONFIRMATION` 已有 Guide 明确依据；其他 Windchill Version 必须重新确认，不得自动外推。
- 如果实际使用 `PROMPT_FOR_CONFIRMATION`，必须同时考虑对应客户端 Wizard Submit 配置，不能只返回一个 Java Status 就假设确认弹窗一定工作。
- 不得把本 Reference 描述为“整个业务系统的最终防线”；它只定义 UI / Wizard 提交阶段的服务端验证模式。
- 不得因为 XWorks 存在 required / optional condition，就把 XWorks Hook 与本 Reference 的 PTC OOTB Validator API 描述为一一对应关系。
- 精确 PTC Class / Method / Signature / Supported / Extendable 状态应通过目标版本 Javadoc / API Lookup 再确认。
- 如与企业 Rules、Project ADR 或 Approved Exception 冲突，以更高优先级约束为准。