@.str.1 = private unnamed_addr constant [5 x i8] c"%lf\0A\00", align 1
define i32 @main() #0 {
%1 = alloca i32, align 4
store i32 0, i32* %1, align 4
%2 = alloca [6x double], align 16
%3 = alloca [2x i32], align 16
%4=alloca double, align 8
store double 2.0, double* %4, align 8
%5=alloca i32, align 4
store i32 0, i32* %5, align 4
%6 = getelementptr inbounds [6 x double], [6 x double]* %2, i64 0, i64 0
store double 2.000000e+00 , double* %6, align 8
%7 = getelementptr inbounds [6 x double], [6 x double]* %2, i64 0, i64 1
store double 2.0 , double* %7, align 8
%8 = getelementptr inbounds [6 x double], [6 x double]* %2, i64 0, i64 2
store double 0.000000e+00 , double* %8, align 8
store double 0.9 , double* %4, align 8
%9 = getelementptr inbounds [6 x double], [6 x double]* %2, i64 0, i64 3
store double 0.9 , double* %9, align 8
%10 = getelementptr inbounds [6 x double], [6 x double]* %2, i64 0, i64 4
store double 0.01 , double* %10, align 8
%11=alloca i32, align 4
store i32 0, i32* %11, align 4
%12= alloca double, align 8
store double 2.0, double* %12, align 8
%13 = load double, double* %12, align 8
%14= call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.1, i32 0, i32 0), double %13)
store i32 1 , i32* %11, align 4
%15= alloca double, align 8
store double 2.0, double* %15, align 8
%16 = load double, double* %15, align 8
%17= call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.1, i32 0, i32 0), double %16)
store i32 2 , i32* %11, align 4
%18= alloca double, align 8
store double 0.0, double* %18, align 8
%19 = load double, double* %18, align 8
%20= call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.1, i32 0, i32 0), double %19)
store i32 3 , i32* %11, align 4
%21= alloca double, align 8
store double 0.9, double* %21, align 8
%22 = load double, double* %21, align 8
%23= call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.1, i32 0, i32 0), double %22)
store i32 4 , i32* %11, align 4
%24= alloca double, align 8
store double 0.01, double* %24, align 8
%25 = load double, double* %24, align 8
%26= call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.1, i32 0, i32 0), double %25)
store i32 5 , i32* %11, align 4
%27= alloca double, align 8
store double 6.0, double* %27, align 8
%28 = load double, double* %27, align 8
%29= call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.1, i32 0, i32 0), double %28)
store i32 6 , i32* %11, align 4
ret i32 0
}
declare i32 @printf(i8*, ...) #1

