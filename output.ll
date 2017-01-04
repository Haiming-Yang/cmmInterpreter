@.str.0 = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
define i32 @main() #0 {
%1 = alloca i32, align 4
store i32 0, i32* %1, align 4
%2 = alloca i32, align 4
%3 = alloca double, align 8
%4 = alloca double, align 8
%5 = alloca double, align 8
%6=alloca double, align 8
store double 23.000000e+00, double* %6, align 8
%7=alloca i32, align 4
store i32 23, i32* %7, align 4
%8 = alloca [2x double], align 16
%9 = getelementptr inbounds [2 x double], [2 x double]* %8, i64 0, i64 0
store double 23.000000e+00 , double* %9, align 8
%10 = getelementptr inbounds [2 x double], [2 x double]* %8, i64 0, i64 1
store double 0.000000e+00 , double* %10, align 8
%11=alloca double, align 8
store double 23.5, double* %11, align 8
%12=alloca i32, align 4
store i32 1, i32* %12, align 4
%13 = load i32, i32* %12, align 4
%14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.0, i32 0, i32 0), i32 %13)
%15 = alloca [1x double], align 16
%16 = getelementptr inbounds [1 x double], [1 x double]* %15, i64 0, i64 0
store double 0.05 , double* %16, align 8
%17=alloca i32, align 4
store i32 1, i32* %17, align 4
%18 = load i32, i32* %17, align 4
%19 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.0, i32 0, i32 0), i32 %18)
ret i32 0
}
declare i32 @printf(i8*, ...) #1

