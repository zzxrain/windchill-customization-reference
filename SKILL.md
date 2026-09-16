---
name: windchill-golden-reference
description: 当任务涉及 Windchill 专有实现模式、设计、代码生成、Code Review 或 Debug 时使用，例如 QuerySpec、DataUtility、Validator、FormProcessor、Listener、StandardManager、Service、Queue、JCA/MVC、Workflow、Configuration 等。对这类任务，Agent 应先扫描 CATALOG.md 判断是否存在直接匹配的企业批准/候选实现模式，用户无需显式提及 Golden Reference。只读取最小充分的 1～3 个 Reference，不要全量加载。
---

# Windchill Golden Reference Skill

## When to use

本 Skill 回答：

> 同类 Windchill 定制通常怎么实现？

典型场景包括：

- 新增 Windchill 二次开发实现；
- 修改已有 Windchill 定制；
- 给出 Windchill-specific 技术设计；
- 生成或修改 Windchill Java 代码；
- Code Review；
- Debug / Troubleshooting 中需要判断正确实现模式；
- 当前项目存在多种历史写法，需要选择更合适的模式。

典型技术主题包括但不限于：

```text
QuerySpec
Persistence
Transaction
Version / Iteration
DataUtility
Validator
FormProcessor
Action / ActionModel
JCA / MVC
Listener
StandardManager
Service
Queue
Workflow
Configuration
XCONF
XWorks
```

用户无需在 Prompt 中显式要求：

```text
Golden Reference
Golden Code
PTC Guide Example
Reference Pattern
```

Agent 应根据任务本身自主判断是否需要本 Skill。

如果当前任务只是：

- 普通文本修改；
- 与 Windchill 无关的 Java 重构；
- 明确的纯算法修改；
- 不依赖任何 Windchill 专有实现模式的局部变更；

则不应为了展示能力而调用本 Skill。

---

## Mandatory Catalog Preflight

当用户要求以下任一行为，并且任务涉及 Windchill 专有机制时：

```text
怎么实现
怎么设计
给代码
修改代码
Code Review
重构 Windchill 定制
排查 Windchill-specific 实现问题
```

Agent 在最终回答前必须先进行一次 Golden Catalog Preflight：

```text
Read CATALOG.md
        ↓
Check direct scenario match
        ↓
No strong match?
        └── Stop Golden lookup

Strong match?
        ↓
Select minimum sufficient Reference
        ↓
Read reference.md
        ↓
Read src/* only when needed
```

Catalog Preflight 不等于加载全部 Golden Repository。

它的目的只是回答：

```text
当前任务是否已经存在直接匹配的企业实现模式？
```

不得因为已经从 QMind / PTC Guide 得到了官方产品知识，就跳过实现模式检查。

同样，不得因为找到了 Golden Reference，就跳过产品事实或 API Metadata 的独立验证。

---

## Selection Preference

Reference 选择顺序：

1. 当前任务 Scenario 是否直接匹配；
2. Project `AGENTS.md`、架构和技术栈约束是否允许；
3. Reference Status 和目标版本适用性；
4. Source Provenance。

Source Provenance 主要用于同等匹配候选之间的判断：

- `PTC Guide`：优先用于理解官方扩展机制、生命周期和推荐集成点；
- `Legacy Project`：用于补充真实项目中的工程化实现、兼容方式和常见上下文；
- `XWorks Guide`：仅在 Project Context 明确允许 XWorks 时用于 XWorks 实现模式。

不得因为 Reference 来自 `PTC Guide`，就选择场景匹配较弱的通用条目替代直接匹配条目。

---

## Minimum Sufficient Selection

Golden Reference 不是“越多越好”。

选择规则：

```text
1 个直接匹配 Reference 已经覆盖问题
→ 只使用 1 个

第二个 Reference 提供独立且不可替代的信息
→ 可以增加

只是重复第一条的通用模式
→ 不增加
```

默认：

```text
1～3 个 Reference
```

是上限，不是目标数量。

例如：

```text
Wizard Post-Submit Validation
→ GR-VALIDATOR-003 已完整覆盖
→ 不应为了数量再添加 Post-Select Reference
```

而：

```text
DataUtility instance cache
→ 一个 Reference 描述 setModelData / prefetch
→ 另一个 Reference 独立描述 registration / cardinality
→ 可以同时使用
```

---

## Reference ID

Reference ID：

```text
GR-<MODULE>-<NNN>
```

ID 是稳定标识，不因 Catalog 排序或新增重新编号。

---

## Workflow

1. 读取当前 Project `AGENTS.md`（如存在）。
2. 从 Project Context、用户输入或项目资料确认已知的 Windchill Version 和 `XWorks Enabled`。
3. 无法确认时不得自行猜测。
4. 对 Windchill-specific implementation / design / review / debug 执行 Catalog Preflight。
5. 先按模块定位，再按 Scenario / Project Constraint / Status / Source / XWorks 筛选候选。
6. 只选择最小充分 Reference。
7. 读取最终选择的 `reference.md`。
8. 只有代码结构确实需要时再读取 `src/*`。
9. 将 Reference 作为实现模式，不机械复制示例业务。
10. 对 Reference 没有证明的事实继续执行 Evidence Handoff。
11. 如 Reference 与 Rules / Project ADR / Approved Exception 冲突，服从更高优先级约束。

---

## Evidence Handoff

Golden Reference 主要证明：

```text
Implementation Pattern
```

它不能自动证明：

```text
Exact API Metadata
Framework Behavior
Compile Verification
Runtime Verification
```

因此在应用 Reference 后，Agent 必须检查是否仍存在以下证据缺口。

### Framework / Product Behavior

例如：

```text
Event veto semantics
Validation phase behavior
DataUtility lifecycle
Wizard client behavior
Queue semantics
Transaction behavior
```

需要：

```text
目标版本 PTC 官方资料
/
QMind
```

不得仅根据 Reference 中的代码形态推导产品行为。

### Exact API / Type Metadata

例如：

```text
Class 是否存在
Method 是否存在
Signature
Return Type
Throws
Constant
Supported
Extendable
Deprecated
Class hierarchy
Implemented interfaces
Versioned / Iterated / Workable 等类型能力
```

需要：

```text
目标版本 Javadoc
/
windchill-api-lookup
```

如果目标版本和 API Lookup 已可用，应实际执行验证。

不得只在回答结尾写：

> 建议再对照 Javadoc 确认。

然后把未经验证的精确 API 当作已确认代码输出。

API Lookup 不可用时，可以继续提供 Pattern-level 方案，但相关精确 API 必须标记为：

```text
UNVERIFIED PTC API
```

### Compile

只有真实 Target Classpath Build 才能证明：

```text
Compile Verified
```

### Runtime

只有实际 Windchill Runtime 才能证明：

```text
Runtime Verified
```

---

## Candidate Policy

当前 Corpus 中的 Reference 主要为：

```text
candidate
```

Candidate 可以用于：

- 设计参考；
- 模式识别；
- 初始代码生成；
- Code Review；
- Benchmark。

Candidate 不应描述为：

```text
企业最终批准的唯一实现
目标项目已经编译验证
目标项目已经 Runtime Verified
```

`guide-derived`、`legacy-project-derived`、`xworks-guide-derived` 描述 Reference 来源，不自动提升其验证级别。

---

## XWorks

只有 Project Context 明确：

```text
XWorks Enabled: true
```

时，才允许选择：

```text
xworks: true
```

的 Reference 作为当前项目实现依据。

如果：

```text
XWorks Enabled: false
```

或无法确认 XWorks 已启用，则不得把 `xworks: true` Reference 作为当前实现方案。

被排除技术栈中的 Reference 最多用于理解通用设计思想，不得据此推导当前技术栈存在等价：

- Class；
- Method；
- Status；
- Hook；
- Framework Behavior。

跨 Framework 的语义相似不能作为 API 或产品行为等价的证据。

---

## Silent Invocation

Golden 的检索、Catalog Preflight 和 Reference 读取属于内部工作过程。

**调用本 Skill、读取 Catalog 或 Reference 前，不得先发送用户可见的进度说明。**

禁止输出：

```text
我先查一下 Golden Reference
我先读取 CATALOG
我找到 GR-XXX，接下来读取它
我先看看企业参考代码
```

正确行为：

```text
内部直接调用 / 读取
        ↓
完成必要证据收集
        ↓
第一个用户可见文本直接回答实际问题
```

只有以下情况可以在最终答案中简要说明具体 Reference：

- 用户明确要求依据；
- Code Review 要求可追溯性；
- Candidate / Approved 状态本身影响结论；
- 多个模式存在重要取舍；
- 某项事实仍然 `UNVERIFIED`；
- 用户正在调试 Golden / DevKit 本身。

即使需要说明，也只说明最终依据，不输出内部检索流水。