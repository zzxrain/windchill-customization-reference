# Windchill Customization Reference

本仓库维护公司内部 Windchill Golden Reference 候选集，为 Windchill AI Coding Agent 提供经过筛选、去客户化和规范化的典型实现模式。

当前内容主要来自：

- 历史 Windchill 项目中抽取并规范化后的可复用模式；
- PTC Windchill Customization Guide 中整理出的典型官方扩展模式；
- XWorks 快速指南中整理出的 XWorks 专用候选模式。

本仓库不是历史项目代码归档，也不是 PTC API 事实库。

精确的目标版本 PTC API 仍应通过 `windchill-api-lookup` 或目标版本官方 Javadoc 验证。

---

## 1. Current Status

当前状态：

```text
Status: Candidate
Runtime Verification: Not Performed
Primary Guide Baseline: Windchill 13.1.2.0 Customization Guide
Total References: 62
```

当前 Reference 尚未整体完成企业级人工 Approval。

因此：

> `candidate` 可以作为设计、代码生成和模式选择参考，但不等同于企业最终批准实现。

随着 Review 推进，单个 Reference 可以独立升级为：

```text
approved
```

无需等待整个 Repository 全部完成 Review。

---

## 2. Purpose

Golden Reference 回答：

> 同类 Windchill 定制，我们认可的实现模式通常怎么写？

它主要用于补充：

```text
Rules
    ↓
告诉 Agent 必须 / 不得怎么做

Golden Reference
    ↓
告诉 Agent 推荐实现模式通常怎么写

API Lookup
    ↓
告诉 Agent 当前目标版本 API 是否真实存在
```

三者不能互相替代。

---

## 3. Source Classification

### PTC Guide Derived

这类 Reference 从 Windchill Customization Guide 的典型案例中提炼，并做：

- 最小化；
- 去示例业务化；
- 注释规范化；
- 企业 AI Coding 场景适配。

这类 Reference 通常比单一历史项目代码更适合作为默认实现方向。

但仍必须：

- 根据目标 Windchill Version 做 Javadoc / API Lookup；
- 根据项目架构判断是否适用；
- 遵守 DevKit Rules；
- 在标记 `approved` 前进行人工 Review。

PTC Guide Derived 不代表目标项目已经：

```text
编译通过
Runtime Verification 通过
```

---

### Legacy Project Derived

这类 Reference 来自真实历史项目。

其价值主要在于：

- 反映真实 Windchill 工程场景；
- 提供历史兼容方式；
- 展示真实项目中的组合调用；
- 补充 Guide 中缺少的工程上下文。

但：

> 历史项目代码不自动等于最佳实践。

历史代码在进入本 Repository 前应尽量完成：

- 去客户化；
- 删除业务无关内容；
- 删除 Secret / Credential；
- 删除明显低质量实现；
- 必要的命名规范化；
- 必要的注释补充；
- 明显 API 错误修正。

如果不能确认实现质量，应继续保持：

```text
candidate
```

---

### XWorks Guide Derived

这类 Reference 来源于 XWorks 指南或经过整理的 XWorks 实践。

仅当项目：

```text
AGENTS.md
```

明确：

```text
XWorks Enabled: true
```

时才允许作为实现候选。

同时必须考虑：

- 当前项目实际 XWorks Version；
- 项目已有 XWorks 封装；
- XWorks API 版本差异；
- 项目自身 ADR / Exception。

项目未启用 XWorks 时，不得因为 Golden Reference 中存在 XWorks 示例而主动引入 XWorks。

---

## 4. Reference ID

Reference ID 使用模块独立流水：

```text
GR-<MODULE>-<NNN>
```

例如：

```text
GR-PERSISTENCE-001
GR-PERSISTENCE-002

GR-QUERY-001
GR-QUERY-002

GR-LISTENER-001
GR-LISTENER-002
```

规则：

1. 每个 Module 从 `001` 独立递增；
2. 新增 Reference 只增加所属 Module 的下一个编号；
3. 已经发布的 ID 不重新编号；
4. 删除 Reference 后允许保留空号；
5. 不复用已经废弃的 ID；
6. ID 应同时用于：
    - Catalog；
    - Reference Directory；
    - `reference.md`；
    - Project Explicit Reference。

ID 是稳定引用，不表示优先级。

---

## 5. Repository Structure

典型结构：

```text
windchill-customization-reference/
├── SKILL.md
├── CATALOG.md
├── SOURCES.md
├── CURATION_NOTES.md
├── README.md
│
└── references/
    ├── persistence/
    ├── query/
    ├── versioning/
    ├── security/
    ├── queue/
    ├── service/
    ├── listener/
    ├── bom/
    ├── content/
    ├── workflow/
    ├── team/
    ├── lifecycle/
    ├── change/
    ├── ui/
    ├── validator/
    ├── config/
    ├── configspec/
    ├── model/
    ├── resource/
    ├── xworks/
    ├── type/
    └── document/
```

Reference 的详细索引维护在：

```text
CATALOG.md
```

---

## 6. Agent Usage

AI Agent 不应一次加载整个 Reference Repository。

推荐流程：

```text
Coding Task
    ↓
Read Project AGENTS.md
    ↓
Understand task domain
    ↓
Read CATALOG.md
    ↓
Select relevant Module
    ↓
Select 1–3 References
    ↓
Read reference.md + src/*
    ↓
Apply DevKit Rules
    ↓
Verify exact PTC API when needed
    ↓
Adapt to current project
```

通常一次任务只应加载最相关的：

```text
1～3
```

个 Reference。

---

## 7. Selection Preference

同一场景存在多个 Reference 时，默认考虑：

```text
PTC Guide Derived
        ↓
Approved Enterprise Reference
        ↓
Candidate Legacy Reference
        ↓
Existing Project Implementation
```

但这不是绝对覆盖关系。

当前项目：

- ADR；
- Approved Exception；
- Compatibility Constraint；
- Windchill Version；
- XWorks Enabled；

都可能改变最终选择。

---

## 8. Candidate Policy

当前大多数条目状态为：

```text
candidate
```

Candidate 可以用于：

- Pattern Discovery；
- Design Reference；
- 初始代码生成；
- Code Review 对比；
- Benchmark。

Candidate 不应该被描述为：

```text
企业最终批准实现
目标项目验证通过
Windchill Runtime 验证通过
```

---

## 9. Approved Policy

Reference 经过人工 Review 后，可以修改为：

```text
approved
```

Approved 至少应确认：

- 场景描述明确；
- 不包含客户专有业务信息；
- 不包含 Secret；
- 实现方向符合企业 Rule；
- 没有已知错误 API；
- Source / Provenance 明确；
- Version Sensitivity 已标注；
- XWorks Dependency 已标注；
- Known Limitation 已标注。

Runtime Verification 是否必须，由 Reference 类型决定。

并不是所有纯 Pattern Reference 都要求单独运行一个 Windchill Runtime Test，但不得虚构不存在的 Runtime Verification。

---

## 10. Deprecated Policy

不再推荐的 Reference 标记：

```text
deprecated
```

Deprecated Reference 可以保留用于：

- 历史项目维护；
- Upgrade；
- Migration；
- Compatibility Analysis。

Agent 不应在新实现中优先采用 Deprecated Reference。

---

## 11. PTC API Verification

Golden Reference 不证明当前目标版本 API 一定存在。

例如 Reference 可能来源：

```text
Windchill 13.1.2.0
```

而当前项目可能是：

```text
Windchill 13.0.2.0
```

或者：

```text
Windchill 2027.0.0.0
```

因此精确 API 事实仍由目标版本：

```text
PTC Javadoc
+
windchill-api-lookup
```

确认。

不得仅因为 Golden Reference 中存在一个调用就认为该 API 对当前版本有效。

---

## 12. XWorks Boundary

`xworks: true` 的 Reference：

```text
只能用于 XWorks Enabled: true 的项目
```

如果项目：

```text
XWorks Enabled: false
```

则 Agent 不得：

- 引入 XWorks Dependency；
- 使用 XWorks API；
- 为了套用 Golden Reference 改变项目技术栈。

---

## 13. Maintenance

新增 Golden Reference 时：

```text
Identify reusable pattern
        ↓
Remove customer-specific context
        ↓
Normalize implementation
        ↓
Assign module-local ID
        ↓
Create Reference
        ↓
Update CATALOG.md
        ↓
Review
        ↓
candidate / approved
```

不要因为：

```text
某项目代码量很大
```

就批量导入所有源码。

Golden Reference 应保持：

```text
High Value
+
Searchable
+
Understandable
+
Reusable
+
Reviewable
```

---

## 14. DevKit Integration

本 Repository 由：

```text
windchill-ai-devkit
```

以 Git Submodule 方式固定版本。

DevKit 中的挂载位置：

```text
skills/windchill-golden-reference
```

发布的 DevKit 必须固定到明确的 Golden Reference Commit。

不要让已发布 DevKit 自动跟随 Golden Repository 最新 `main`。

推荐关系：

```text
Windchill AI DevKit Release
        │
        └── Golden Reference @ exact commit SHA
```

这样可以保证同一个 DevKit Release 的行为可复现。

---

## 15. Core Principle

Golden Reference 的目标不是：

```text
保存越多代码越好
```

而是：

```text
把值得复用的 Windchill 实现模式
变成 Agent 可以稳定发现、理解和采用的企业代码资产
```