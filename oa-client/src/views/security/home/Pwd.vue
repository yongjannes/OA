


<template>
    <el-dialog v-model="visible" title="修改密码" width="500" style="padding-bottom:25px;">
        <el-form ref="formRef" :model="data" :rules="rules" label-width="95" style="padding:10px 45px 10px 0px;" >
            <el-form-item label="原密码" prop="old_pwd">
                <el-input v-model="data.old_pwd" type="password" show-password />
            </el-form-item>
            <el-form-item label="新密码" prop="new_pwd">
                <el-input v-model="data.new_pwd" type="password" show-password />
            </el-form-item>
            <el-form-item label="确认密码" prop="re_pwd">
                <el-input v-model="data.re_pwd" type="password" show-password />
            </el-form-item>
        </el-form>

        <template #footer>
            <el-button type="primary" @click="confirmUpdatePassword">确认修改</el-button>
            <el-button @click="visible = false">关闭</el-button>
        </template>

    </el-dialog>
</template>


<style scoped>

</style>