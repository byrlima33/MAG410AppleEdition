MAG410 Apple Edition - projecto Android

Este projecto ainda e uma primeira versao experimental. Nao substitui nem remove o launcher original da MAG410.

COMPILAR SEM INSTALAR ANDROID STUDIO (GitHub Actions)
1. Crie um repositorio no GitHub (pode ser privado) com o nome MAG410AppleEdition.
2. Extraia este ZIP no computador.
3. No repositorio, use Add file > Upload files e carregue o CONTEUDO da pasta MAG410AppleEdition, incluindo a pasta oculta .github.
4. Aguarde o workflow "Build MAG410 Apple Edition APK" terminar no separador Actions.
5. Abra a execucao concluida e descarregue o artifact "MAG410-Apple-Edition-debug". Dentro do ZIP do artifact estara app-debug.apk.

NOTAS
- O workflow compila com Java 17 e Gradle 8.2 no GitHub Actions.
- O APK e de teste e ainda nao foi validado fisicamente na MAG410 / Android 6.0.1.
- Nao desactive nem desinstale o MAGicLauncher original.
- Antes de escolher o novo launcher como predefinido, confirme que consegue abrir o launcher original e que tem um metodo de recuperacao.
