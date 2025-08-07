<script setup>
import { ref, reactive } from 'vue'
import req from '@/request'
import { ElMessage, ElMessageBox } from 'element-plus'
import { useRouter } from 'vue-router'
import { v4 as uuidv4 } from 'uuid';//导入uuid生成函数
import { apiBaseUrl, localTokenName } from '@/constants'

const router = useRouter();

const loginFormRef = ref(null);

const verify_code_url = ref('');

const getVerifyCodeUrl = () => {
    data.u_verify_key = uuidv4();
    verify_code_url.value = apiBaseUrl + "/res/verifycode?u_verify_key=" + data.u_verify_key
}

const data = reactive({
    u_id: '',
    u_pwd: '',
    u_verify_code: '',
    u_verify_key: ''
});

getVerifyCodeUrl();


const login = async () => {

    const res = await req.post('/security/login', data);
    ElMessage.success('登录成功！');
    const token = res.data;
    localStorage.setItem(localTokenName, token);
    router.push({ path: '/security/home' })

}


</script>

<template>
    <div style="position: fixed;top:0;bottom:0;left:0px;right:0;background-color: #EEE;">

        <div style="position: absolute;top:calc( 50% - 350px);left:calc( 50% - 450px);
        box-sizing: border-box; height:700px;width:900px;background-color: white;border-radius: 5px;
        box-shadow: 0 0 5px 1px #DDD;display: flex;flex-direction: column;align-items: center;">

            <h1 style="font-size:80px;color:#777;letter-spacing: 5px;font-family: 隶书; margin-top:120px;">文都OA云协同</h1>

            <el-form style="width:350px;padding-right:15px;" label-width="70px" ref="loginFormRef">
                <el-form-item label="账户">
                    <el-input v-model="data.u_id" />
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="data.u_pwd" type="password" show-password />
                </el-form-item>

                <el-form-item label="验证码" prop="u_verify_code">
                    <el-input v-model="data.u_verify_code" style="width:195px;" />
                    <div style="height:40px;margin-left:5px;" @click="getVerifyCodeUrl">
                        <el-image style="height: 100%;border-radius: 3px;" :src="verify_code_url" fit="scale-down" />
                    </div>

                </el-form-item>

                <el-form-item style="margin-top:30px;">
                    <el-button type="primary" @click="login" style="flex:auto;">登录</el-button>
                </el-form-item>

            </el-form>

        </div>

    </div>
</template>



<style scoped></style>