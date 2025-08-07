<h1 align="center">文都 OA 云协同系统</h1>

<p align="center">
  <a href="http://18.221.150.100:8088/"><img src="https://img.shields.io/badge/Demo-在线预览-green?style=for-the-badge&logo=Cloudflare" alt="Live Demo"></a>
  <a href="https://gitee.com/yongjannes/oa/stargazers"><img src="https://gitee.com/yongjannes/oa/badge/star.svg?theme=dark" alt="Gitee star"></a>
  <img src="https://img.shields.io/badge/Vue-3.x-4FC08D?logo=vue.js" alt="Vue3">
  <img src="https://img.shields.io/badge/Spring--Boot-2.x-6DB33F?logo=spring" alt="SpringBoot">
  <a href="./LICENSE"><img src="https://img.shields.io/badge/license-MIT-blue.svg" alt="license"></a>
</p>

## 🧭 导航目录

- [📖 项目简介](#-项目简介)
- [✨ 功能模块](#-功能模块)
- [📸 系统预览](#-系统预览)
- [🚀 技术栈](#-技术栈)
- [📦 环境准备与启动](#-环境准备与启动)

## 📖 项目简介

**文都 OA 云协同系统** 是一个基于前后端分离架构实现的现代化办公自动化平台。旨在通过简洁友好的用户界面和稳定可靠的后端服务，为企业提供一套完整、高效、安全的协同办公解决方案。

- **Gitee 仓库地址:** [https://gitee.com/yongjannes/oa](https://gitee.com/yongjannes/oa)

---

## ✨ 功能模块

系统核心功能围绕三大模块构建，所有功能均已完成开发。

#### 🔐 安全管理 (Security Management)

- [x] **用户登录/退出**: 基于 Token 的安全身份验证。
- [x] **用户管理**: 新增、查询、修改、删除系统用户，支持角色分配。
- [x] **角色管理**: 自定义角色，为角色精细化配置菜单和操作权限。
- [x] **密码修改**: 用户可自行修改密码，保障账户安全。

#### 🏢 基础信息 (Basic Information)

- [x] **部门管理**: 维护企业树状组织架构。
- [x] **员工管理**: 统一管理企业员工档案信息。

#### 📄 业务管理 (Business Management)

- [x] **请假流程**:
  - [x] **请假申请与销假**: 员工在线提交请假单，假期结束后可进行销假。
  - [x] **请假审批**: 上级领导在线审批下属的请假申请（同意/驳回）。

---

## 📸 系统预览

|                           登录页面                           |                           用户管理                           |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| ![image-20250807142408132](https://raw.githubusercontent.com/yongjannes/Pictures/master/img/20250807142408171.png) | ![image-20250807142422287](https://raw.githubusercontent.com/yongjannes/Pictures/master/img/20250807142422362.png) |
|                         **角色管理**                         |                         **部门管理**                         |
| ![image-20250807142429157](C:/Users/JY/AppData/Roaming/Typora/typora-user-images/image-20250807142429157.png) | ![image-20250807142449870](https://raw.githubusercontent.com/yongjannes/Pictures/master/img/20250807142449942.png) |
|                         **员工管理**                         |                         **请假申请**                         |
| ![image-20250807142458221](https://raw.githubusercontent.com/yongjannes/Pictures/master/img/20250807142458294.png) | ![image-20250807142506127](https://raw.githubusercontent.com/yongjannes/Pictures/master/img/20250807142506205.png) |
|                         **请假审批**                         |                                                              |
| ![image-20250807142510631](https://raw.githubusercontent.com/yongjannes/Pictures/master/img/20250807142510691.png) |                                                              |


---

## 🚀 技术栈

本项目采用业界主流且高效的技术栈，确保了系统的先进性、高性能和良好的可维护性。

| 分类     | 技术栈                                    | 描述                                                         |
| :------- | :---------------------------------------- | :----------------------------------------------------------- |
| **前端** | `Vue3` `Vite4` `Vant4` `Axios`            | 采用最新的 Vue 生态，Vite 提供极速开发体验，Vant 适配移动端。 |
| **后端** | `SpringBoot` `MyBatis` `Sa-Token` `MySQL` | SpringBoot 简化开发，MyBatis 灵活操作数据库，Sa-Token 提供安全认证。 |
| **架构** | `前后端分离` `RESTful API`                | 模式清晰，分工明确，通过 RESTful API 进行松耦合的数据交互。  |

---

## 📦 环境准备与启动

在运行本项目前，请确保您的开发环境中已经安装了以下软件：

-   `Node.js` (推荐 v16+)
-   `JDK` (推荐 1.8+)
-   `Maven` (推荐 3.6+)
-   `MySQL` (推荐 5.7+)

### ▶️ 后端启动

1.  克隆后端代码到本地。
2.  使用 IDE (如 IntelliJ IDEA) 打开后端项目。
3.  修改 `application.yml` 文件，配置您的 **MySQL 数据库**连接信息。
4.  执行 `sql` 目录下的数据库脚本，初始化数据库和表结构。
5.  运行主程序 `main` 方法，启动 SpringBoot 应用。

### ▶️ 前端启动

1.  克隆前端代码到本地。
2.  进入前端项目根目录，打开终端。
3.  **安装依赖** (首次运行时执行):
    ```bash
    npm install
    ```
4.  **启动开发服务器**:
    ```bash
    npm run dev
    ```
5.  启动成功后，根据命令行提示的地址 (通常是 `http://localhost:5173`) 在浏览器中访问。

---

### 🔑 默认账号

-   **管理员账号**: `admin`

-   **密码**: `123456`  (如果不是，请根据您的实际数据填写)
